"use client";
import Image from "next/image";
import { Plus } from "lucide-react";
import { useCartStore } from "@/store/useCartStore";

const MenuCard = ({
  id,
  title,
  description,
  price,
  image,
}: {
  id: string;
  title: string;
  description: string;
  price: number;
  image: string;
}) => {
  const addToCart = useCartStore((state) => state.addToCart);

  const handleAdd = () => {
    addToCart({
      id,
      name: title,
      price,
      imageUrl: image,
      quantity: 1,
    });
  };

  return (
    <div className="flex h-full flex-col overflow-hidden rounded-3xl border border-slate-200 bg-white shadow-sm shadow-slate-200/50">
      <div className="relative h-48 w-full">
        <Image
          src={
            image ||
            "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?w=500"
          }
          alt={title || "Dish image"}
          fill
          unoptimized
          className="object-cover"
          sizes="(max-width: 768px) 100vw, 50vw"
        />
      </div>

      <div className="p-4 flex flex-col flex-1">
        <h3 className="text-lg font-bold text-primary">{title}</h3>
        <p className="text-gray-600 mt-2 mb-4">{description}</p>

        <div className="flex flex-row items-center justify-between w-full mt-auto">
          <p className="text-xl font-bold text-primary">
            ${(price ?? 0).toFixed(2)}
          </p>

          <button
            onClick={handleAdd}
            className="p-2 bg-primary text-white rounded-full transition-transform duration-150 ease-out hover:scale-105 active:scale-95 focus:outline-none focus:ring-2 focus:ring-primary/50"
          >
            <Plus size={16} />
          </button>
        </div>
      </div>
    </div>
  );
};

export default MenuCard;
