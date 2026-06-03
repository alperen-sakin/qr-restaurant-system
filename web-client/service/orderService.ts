import { collection, addDoc, serverTimestamp } from "firebase/firestore";
import { db } from "@/lib/firebase";

export const createOrder = async (
  tableNumber: string,
  items: any[],
  total: number,
) => {
  try {
    const docRef = await addDoc(collection(db, "orders"), {
      tableNumber,
      items,
      total,
      status: "pending",
      createdAt: serverTimestamp(),
    });
    return docRef.id;
  } catch (error) {
    console.error("Error creating order:", error);
    throw error;
  }
};
