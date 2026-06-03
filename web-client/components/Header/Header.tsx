"use client";

import { useCartStore } from "@/store/useCartStore";
import { Utensils } from "lucide-react";
import { useSearchParams } from "next/navigation";
import { useEffect } from "react";

const Header = () => {
  const searcgParams = useSearchParams();
  const tableFromUrl = searcgParams.get("table");

  const tableNumber = useCartStore((state) => state.tableNumber);
  const setTableNumber = useCartStore((state) => state.setTableNumber);

  useEffect(() => {
    if (tableFromUrl) {
      setTableNumber(tableFromUrl);
    }
  }, [tableFromUrl, setTableNumber]);

  if (!tableNumber) return null;

  return (
    <header className="sticky top-0 z-20 bg-surface/80 w-full border-b border-borderColor backdrop-blur-sm px-4 py-4">
      <div className="flex items-center justify-between gap-4">
        <div className="flex items-center gap-3">
          <Utensils size={24} color="var(--color-primary)" />
          <h1 className="text-primary text-xl font-semibold">Sync Plate</h1>
        </div>

        <div className="bg-table text-sm font-bold text-primary p-2 rounded-full border border-borderColor">
          <h2>TABLE {tableNumber}</h2>
        </div>
      </div>
    </header>
  );
};

export default Header;
