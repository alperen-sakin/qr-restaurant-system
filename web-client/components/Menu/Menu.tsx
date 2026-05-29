"use client";

import { useState } from "react";
import CategoryTabs from "../CategoryTabs/CategoryTabs";
import { CATEGORIES } from "@/constants";

type MenuProps = {
  pruducts: any[];
};

const Menu = ({ pruducts }: MenuProps) => {
  const [activeCategory, setActiveCategory] = useState("appetizers");

  const filteredProducts =
    activeCategory === "appetizers"
      ? pruducts.filter((product) => product.category === "appetizers")
      : pruducts.filter((product) => product.category === activeCategory);

  return (
    <div>
      <CategoryTabs
        categories={CATEGORIES}
        activeCategory={activeCategory}
        onCategoryChange={setActiveCategory}
      />

      <div>
        {filteredProducts.map((product) => (
          <div key={product.id}>
            <h3>{product.name}</h3>
            <p>{product.category}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Menu;
