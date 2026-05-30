"use client";
import { Product } from "@/service/productService";
import { useState } from "react";
import MenuCard from "../MenuCard/MenuCard";

type MenuProps = {
  products: Product[];
};

const Search = ({ products }: MenuProps) => {
  const [searchTerm, setSearchTerm] = useState("");

  const filteredProducts = products.filter((product) =>
    (product.name ?? "").toLowerCase().includes(searchTerm.toLowerCase()),
  );

  return (
    <div className="flex flex-col gap-4">
      <input
        type="text"
        placeholder="Search for dishes..."
        onChange={(e) => setSearchTerm(e.target.value)}
        className="w-full p-3 mt-4 rounded-lg border border-borderColor focus:outline-none focus:ring-2 focus:ring-primary"
      />

      <div className="grid grid-cols-2 gap-4 mt-4 mb-4">
        {filteredProducts.map((product) => (
          <MenuCard
            key={product.id}
            title={product.name}
            description={product.description}
            price={product.price}
            image={product.imageUrl}
          />
        ))}
      </div>
    </div>
  );
};

export default Search;
