import { UtensilsCrossed, Search, ShoppingCart } from "lucide-react";

export const NAV_ITEMS = [
  { id: "menu", title: "Menu", href: "/menu", icon: UtensilsCrossed },
  { id: "search", title: "Search", href: "/search", icon: Search },
  { id: "cart", title: "Cart", href: "/cart", icon: ShoppingCart },
];

export const CATEGORIES = [
  { id: "appetizers", title: "Appetizers" },
  { id: "mains", title: "Main Course" },
  { id: "desserts", title: "Desserts" },
  { id: "drinks", title: "Drinks" },
];
