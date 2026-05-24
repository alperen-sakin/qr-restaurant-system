"use client";

import { getProducts } from "@/service/productService";
import { useState, useEffect } from "react";

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
    <div>
      {products.map((products) => (
        <div key={products.id}>
          <h2>{products.name}</h2>
        </div>
      ))}
    </div>
  );
};

export default page;
