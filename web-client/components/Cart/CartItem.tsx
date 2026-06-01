import { useCartStore } from "@/store/useCartStore";
import { Minus, Plus, X } from "lucide-react";
import Image from "next/image";

type CartItemProps = {
  id: string;
  name: string;
  price: number;
  quantity: number;
  imageUrl?: string;
};

const CartItem = ({ id, name, price, quantity, imageUrl }: CartItemProps) => {
  const removeFromCart = useCartStore((state) => state.removeFromCart);
  const updateQuantity = useCartStore((state) => state.updateQuantity);

  const handleRemove = () => {
    removeFromCart(id);
  };

  const handleDecrease = () => {
    if (quantity <= 1) {
      removeFromCart(id);
      return;
    }

    updateQuantity(id, quantity - 1);
  };

  const handleIncrease = () => {
    updateQuantity(id, quantity + 1);
  };

  return (
    <div className="flex flex-col gap-4 p-4 border border-borderColor rounded-2xl bg-white shadow-sm sm:flex-row sm:items-center">
      <div className="relative w-full h-40 rounded-3xl overflow-hidden bg-surface-variant sm:w-24 sm:h-24">
        {imageUrl ? (
          <Image
            src={imageUrl}
            alt={name || "Product image"}
            fill
            className="object-cover"
            sizes="96px"
          />
        ) : (
          <div className="flex h-full w-full items-center justify-center bg-gray-100 text-sm text-gray-500">
            No image
          </div>
        )}
      </div>

      <div className="flex-1">
        <div className="flex items-start justify-between gap-4">
          <div>
            <h3 className="text-base font-bold text-primary">{name}</h3>
            <p className="text-sm text-gray-500">
              {quantity} piece{quantity === 1 ? "" : "s"}
            </p>
          </div>
          <button
            type="button"
            className="rounded-full p-2 text-gray-500 transition hover:bg-gray-100 hover:text-red-600"
            onClick={handleRemove}
          >
            <X className="w-4 h-4" />
          </button>
        </div>

        <div className="mt-3 flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
          <span className="text-lg font-semibold text-primary">
            ${(price * quantity).toFixed(2)}
          </span>
          <div className="flex items-center justify-between gap-3 rounded-full border border-borderColor bg-surface-variant p-2">
            <button
              type="button"
              className="rounded-full p-2 text-primary transition hover:bg-primary/10"
              onClick={handleDecrease}
            >
              <Minus className="w-4 h-4" />
            </button>
            <span className="w-6 text-center font-medium text-primary">
              {quantity}
            </span>
            <button
              type="button"
              className="rounded-full p-2 text-primary transition hover:bg-primary/10"
              onClick={handleIncrease}
            >
              <Plus className="w-4 h-4" />
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CartItem;
