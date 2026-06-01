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
    `${product.name ?? ""} ${product.description ?? ""}`
      .toLowerCase()
      .includes(searchTerm.toLowerCase()),
  );

  return (
    <section className="flex flex-col gap-4">
      <div className="relative mt-4 w-full">
        <input
          type="text"
          value={searchTerm}
          placeholder="Search for dishes..."
          onChange={(e) => setSearchTerm(e.target.value)}
          className="w-full rounded-2xl border border-borderColor bg-white px-4 py-3 text-sm shadow-sm outline-none transition focus:border-primary focus:ring-2 focus:ring-primary/20"
          autoComplete="off"
          aria-label="Search for dishes"
        />
        {searchTerm && (
          <button
            type="button"
            onClick={() => setSearchTerm("")}
            className="absolute right-3 top-1/2 -translate-y-1/2 rounded-full bg-gray-100 px-3 py-1 text-xs font-semibold text-gray-700 transition hover:bg-gray-200"
          >
            Clear
          </button>
        )}
      </div>

      {filteredProducts.length === 0 ? (
        <div className="rounded-3xl border border-borderColor bg-white p-8 text-center text-sm text-gray-500 shadow-sm">
          No dishes match your search. Try a different keyword.
        </div>
      ) : (
        <div className="grid grid-cols-1 gap-4 mt-4 mb-4 sm:grid-cols-2 xl:grid-cols-3">
          {filteredProducts.map((product) => (
            <MenuCard
              id={product.id}
              key={product.id}
              title={product.name}
              description={product.description}
              price={product.price}
              image={product.imageUrl}
            />
          ))}
        </div>
      )}
    </section>
  );
};

export default Search;
