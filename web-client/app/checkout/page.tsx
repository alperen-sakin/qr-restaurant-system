"use client";

import { createOrder } from "@/service/orderService";
import { useCartStore } from "@/store/useCartStore";
import { useRouter } from "next/navigation";

const CheckoutPage = () => {
  const router = useRouter();
  const { cartItems, tableNumber, clearCart } = useCartStore();

  const total = cartItems.reduce(
    (sum, item) => sum + item.price * item.quantity,
    0,
  );

  const handleConfirmOrder = async () => {
    if (!tableNumber) {
      alert("Table number is missing. Please go back and select a table.");
      return;
    }

    try {
      await createOrder(tableNumber, cartItems, total);

      alert(`Order for table ${tableNumber} has been placed successfully!`);
      clearCart();
      router.push("/menu");
    } catch (error) {
      alert("There was an error placing your order. Please try again.");
    }
  };

  if (cartItems.length === 0) {
    return (
      <div className="p-8 text-center text-gray-500">Your cart is empty.</div>
    );
  }

  return (
    <div className="max-w-md mx-auto p-4 flex flex-col gap-6 mt-8">
      <h1 className="text-2xl font-bold uppercase tracking-wide">
        Order Summary
      </h1>

      <div className="bg-[#1a1a1a] border-2 border-[#FFD700] rounded-none p-6 flex flex-col gap-4 text-white">
        <div className="flex justify-between border-b border-gray-700 pb-2 mb-2">
          <span className="text-sm font-bold uppercase tracking-widest text-gray-400">
            Table
          </span>
          <span className="font-bold text-[#FFD700]">
            {tableNumber || "Unknown"}
          </span>
        </div>

        {cartItems.map((item) => (
          <div key={item.id} className="flex justify-between text-sm">
            <span>
              {item.quantity}x {item.name}
            </span>
            <span>${(item.price * item.quantity).toFixed(2)}</span>
          </div>
        ))}

        <div className="flex justify-between border-t border-[#FFD700] pt-4 mt-2 text-lg font-bold text-[#FFD700]">
          <span>Total</span>
          <span>${total.toFixed(2)}</span>
        </div>
      </div>

      <button
        onClick={handleConfirmOrder}
        className="w-full bg-[#FFD700] text-black font-bold uppercase tracking-widest py-4 rounded-none border-2 border-[#FFD700] hover:bg-black hover:text-[#FFD700] transition-colors"
      >
        Confirm Order
      </button>
    </div>
  );
};

export default CheckoutPage;
