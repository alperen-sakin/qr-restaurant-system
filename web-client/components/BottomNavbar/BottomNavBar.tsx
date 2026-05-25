"use client";
import NavItem from "./NavItem";
import { NAV_ITEMS } from "@/constants";

const BottomNavBar = () => {
  return (
    <div className="bg-surface w-full flex flex-row items-center justify-around  border-t border-borderColor">
      {NAV_ITEMS.map((item) => (
        <NavItem
          key={item.id}
          title={item.title}
          icon={item.icon}
          href={item.href}
        />
      ))}
    </div>
  );
};

export default BottomNavBar;
