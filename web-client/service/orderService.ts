import {
  collection,
  addDoc,
  serverTimestamp,
  doc,
  runTransaction,
} from "firebase/firestore";
import { db } from "@/lib/firebase";

export const createOrder = async (
  tableNumber: string,
  items: any[],
  total: number,
) => {
  try {
    // 1. Sayacın durduğu merkezi döküman referansı
    const counterRef = doc(db, "counters", "orders");

    // 2. Yeni eklenecek siparişin referansı (İçi boş olarak ID'si oluşturulur)
    const newOrderRef = doc(collection(db, "orders"));

    // Transaction başlatıyoruz
    await runTransaction(db, async (transaction) => {
      const counterDoc = await transaction.get(counterRef);

      let nextOrderNumber = 100; // Eğer veritabanında hiç sayı yoksa 100'den başlasın

      if (counterDoc.exists() && counterDoc.data().lastOrderNumber) {
        // Mevcut sayıyı 1 artırıyoruz
        nextOrderNumber = counterDoc.data().lastOrderNumber + 1;
      }

      // 1. İşlem: Sayacı yeni sayı ile güncelliyoruz
      transaction.set(
        counterRef,
        { lastOrderNumber: nextOrderNumber },
        { merge: true },
      );

      // 2. İşlem: Siparişi oluşturuyoruz ve ürettiğimiz 'nextOrderNumber'ı içine koyuyoruz
      transaction.set(newOrderRef, {
        orderNumber: nextOrderNumber, // Sıralı numara buraya eklendi
        tableNumber,
        items,
        total,
        status: "pending",
        createdAt: serverTimestamp(),
      });
    });

    return newOrderRef.id;
  } catch (error) {
    console.error("Error creating order:", error);
    throw error;
  }
};
