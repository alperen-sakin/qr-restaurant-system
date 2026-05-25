"use client";

import { getProducts } from "@/service/productService";
import { useState, useEffect } from "react";
import Menu from "@/components/Menu/Menu";

const page = () => {
  const [products, setProducts] = useState<any[]>([]);

  useEffect(() => {
    const fetchProducts = async () => {
      const data = await getProducts();
      setProducts(data);
    };

    fetchProducts();
  }, []);

  return (
    <div className="flex-1">
      <Menu />
    </div>
  );
};

export default page;
