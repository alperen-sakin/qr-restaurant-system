import Image from "next/image";
import { Plus } from "lucide-react";

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
    <div className="flex h-full flex-col overflow-hidden rounded-3xl border border-slate-200 bg-white shadow-sm shadow-slate-200/50">
      <div className="relative h-48 w-full">
        <Image
          src={image}
          alt={title}
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
          <p className="text-xl font-bold text-primary">${price?.toFixed(2)}</p>

          <button className="p-2 bg-primary text-white rounded-full transition">
            <Plus size={16} />
          </button>
        </div>
      </div>
    </div>
  );
};

export default MenuCard;
