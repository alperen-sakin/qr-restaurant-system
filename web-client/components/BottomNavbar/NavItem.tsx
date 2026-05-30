"use client";
import { LucideIcon } from "lucide-react";
import Link from "next/link";
import { usePathname } from "next/navigation";
import { motion } from "framer-motion"; // Framer motion eklendi

type NavItemProps = {
  title: string;
  icon: LucideIcon;
  href: string;
};

const NavItem = ({ title, icon: Icon, href }: NavItemProps) => {
  const pathname = usePathname();
  const isActive = pathname === href;

  return (
    <Link
      href={href}
      className="relative flex flex-col items-center justify-between gap-1 cursor-pointer p-2 w-full"
    >
      {isActive && (
        <>
          <motion.div
            layoutId="nav-light"
            className="absolute top-0 left-1/2 -translate-x-1/2 w-[70%] h-full bg-gradient-to-b from-primary/20 to-transparent rounded-t-xl pointer-events-none"
            transition={{ type: "spring", stiffness: 300, damping: 30 }}
          />

          <motion.div
            layoutId="nav-umbrella"
            className="absolute top-0 left-1/2 -translate-x-1/2 w-[70%] h-2 border-t-2 border-x-2 border-primary rounded-t-xl border-b-0 pointer-events-none"
            transition={{ type: "spring", stiffness: 300, damping: 30 }}
          />
        </>
      )}

      <div
        className={`relative z-10 p-2 rounded-full transition-colors duration-300 ${isActive ? "" : "bg-surface-variant"}`}
      >
        <Icon
          size={24}
          className={`transition-colors duration-300 ${isActive ? "text-primary" : "text-gray-400"}`}
        />
      </div>

      <span
        className={`relative z-10 text-xs transition-colors duration-300 ${isActive ? "text-primary font-bold" : "text-gray-400 font-medium"}`}
      >
        {title}
      </span>
    </Link>
  );
};

export default NavItem;
