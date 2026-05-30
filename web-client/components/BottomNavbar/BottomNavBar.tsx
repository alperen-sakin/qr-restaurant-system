"use client";
import NavItem from "./NavItem";
import { NAV_ITEMS } from "@/constants";

const BottomNavBar = () => {
  return (
    <div className="sticky bottom-0 z-20 bg-surface w-full border-t border-borderColor shadow-[0_-2px_12px_rgba(15,23,42,0.08)]">
      <div className="flex w-full flex-row items-center justify-around">
        {NAV_ITEMS.map((item) => (
          <NavItem
            key={item.id}
            title={item.title}
            icon={item.icon}
            href={item.href}
          />
        ))}
      </div>
    </div>
  );
};

export default BottomNavBar;
