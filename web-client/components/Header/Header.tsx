import { Utensils } from "lucide-react";
import React from "react";

const Header = () => {
  return (
    <header className="bg-surface w-full flex flex-row items-center justify-between p-4 border-b border-b-primary">
      <div className="flex flex-row items-center gap-4">
        <Utensils size={24} color="var(--color-primary)" />
        <h1 className="text-primary text-xl font-semibold ">Sync Plate</h1>
      </div>

      <div className="bg-table text-sm font-bold text-primary p-2 rounded-full border border-primary">
        <h2>TABLE 12</h2>
      </div>
    </header>
  );
};

export default Header;
