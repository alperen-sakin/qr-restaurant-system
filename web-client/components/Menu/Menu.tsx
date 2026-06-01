"use client";

import { useState } from "react";
import CategoryTabs from "../CategoryTabs/CategoryTabs";
import { CATEGORIES } from "@/constants";
import MenuCard from "../MenuCard/MenuCard";
import type { Product } from "@/service/productService";

type MenuProps = {
  products: Product[];
};

const Menu = ({ products }: MenuProps) => {
  const [activeCategory, setActiveCategory] = useState("appetizers");

  const filteredProducts = products.filter(
    (product) => product.category === activeCategory,
  );

  return (
    <div>
      <CategoryTabs
        categories={CATEGORIES}
        activeCategory={activeCategory}
        onCategoryChange={setActiveCategory}
      />

      <div className="grid grid-cols-2 gap-4 mt-4 mb-4">
        {filteredProducts.map((product) => (
          <MenuCard
            key={product.id}
            id={product.id}
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

export default Menu;
