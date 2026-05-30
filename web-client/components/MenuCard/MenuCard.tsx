import { Plus } from "lucide-react";
import React from "react";

const MenuCard = ({
  title,
  description,
  price,
  image,
}: {
  title: string;
  description: string;
  price: number;
  image: string;
}) => {
  return (
    <div className="border border-gray-300 rounded-lg overflow-hidden flex flex-col h-full shadow-sm">
      <img src={image} alt={title} className="w-full h-48 object-cover" />

      <div className="p-4 flex flex-col flex-1">
        <h3 className="text-lg font-bold text-primary">{title}</h3>
        <p className="text-gray-600 mt-2 mb-4">{description}</p>

        <div className="flex flex-row items-center justify-between w-full mt-auto">
          <p className="text-xl font-bold text-primary">${price.toFixed(2)}</p>

          <button className="p-2 bg-primary text-white rounded-full transition">
            <Plus size={16} />
          </button>
        </div>
      </div>
    </div>
  );
};

export default MenuCard;
