"use client";

import Menu from "@/components/Menu/Menu";
import { getProducts, type Product } from "@/service/productService";
import { useEffect, useState } from "react";

const MenuPage = () => {
  const [products, setProducts] = useState<Product[]>([]);

  useEffect(() => {
    const fetchProducts = async () => {
      const data = await getProducts();
      setProducts(data);
    };

    fetchProducts();
  }, []);

  return (
    <main className="flex-1">
      <Menu products={products} />
    </main>
  );
};

export default MenuPage;
