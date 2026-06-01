"use client";
import { useCartStore } from "@/store/useCartStore";
import CartItem from "./CartItem";
import PriceBox from "./PriceBox";

const Cart = () => {
  const cartItems = useCartStore((state) => state.cartItems);

  const itemCount = cartItems.reduce((total, item) => total + item.quantity, 0);
  const subtotal = cartItems.reduce(
    (total, item) => total + item.price * item.quantity,
    0,
  );

  return (
    <div className="flex flex-col max-w-3xl mx-auto p-4 justify-between">
      <div className="flex items-center gap-4 pb-2 mt-4 mb-6 justify-between border-b border-borderColor">
        <div>
          <h1 className="text-2xl font-bold">Your Order</h1>
          <p className="text-sm text-gray-500">
            Review your selected items before checkout.
          </p>
        </div>
        <span className="text-sm text-gray-500">
          {itemCount} item{itemCount === 1 ? "" : "s"}
        </span>
      </div>

      <div className="space-y-4">
        {cartItems.map((item) => (
          <CartItem
            id={item.id}
            key={item.id}
            name={item.name}
            price={item.price}
            quantity={item.quantity}
            imageUrl={item.imageUrl}
          />
        ))}
      </div>

      <PriceBox subtotal={subtotal} taxRate={0.1} />
    </div>
  );
};

export default Cart;
