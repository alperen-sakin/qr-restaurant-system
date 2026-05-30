"use client";
import Search from "@/components/Search/Search";
import { getProducts, Product } from "@/service/productService";
import { useEffect, useState } from "react";

const page = () => {
  const [products, setProducts] = useState<Product[]>([]);

  useEffect(() => {
    const fetchProducts = async () => {
      const data = await getProducts();
      setProducts(data);
    };

    fetchProducts();
  }, []);
  return (
    <div className="flex-1">
      <Search products={products} />
    </div>
  );
};

export default page;
