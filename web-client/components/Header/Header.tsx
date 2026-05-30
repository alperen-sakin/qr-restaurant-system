import { Utensils } from "lucide-react";

const Header = () => {
  return (
    <header className="sticky top-0 z-20 bg-surface/80 w-full border-b border-borderColor backdrop-blur-sm px-4 py-4">
      <div className="flex items-center justify-between gap-4">
        <div className="flex items-center gap-3">
          <Utensils size={24} color="var(--color-primary)" />
          <h1 className="text-primary text-xl font-semibold">Sync Plate</h1>
        </div>

        <div className="bg-table text-sm font-bold text-primary p-2 rounded-full border border-borderColor">
          <h2>TABLE 12</h2>
        </div>
      </div>
    </header>
  );
};

export default Header;
