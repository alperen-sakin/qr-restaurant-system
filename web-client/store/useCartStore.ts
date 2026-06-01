import { create } from "zustand";

export type CartItem = {
  id: string;
  name: string;
  price: number;
  quantity: number;
  imageUrl?: string;
};

type CartStore = {
  cartItems: CartItem[];
  addToCart: (item: CartItem) => void;
  removeFromCart: (id: string) => void;
  updateQuantity: (id: string, quantity: number) => void;
  clearCart: () => void;
};

export const useCartStore = create<CartStore>((set) => ({
  cartItems: [],

  addToCart: (newItem) =>
    set((state) => {
      const existingItem = state.cartItems.find(
        (item) => item.id === newItem.id,
      );

      if (existingItem) {
        return {
          cartItems: state.cartItems.map((item) =>
            item.id === newItem.id
              ? { ...item, quantity: item.quantity + 1 }
              : item,
          ),
        };
      }

      return { cartItems: [...state.cartItems, { ...newItem, quantity: 1 }] };
    }),

  removeFromCart: (id) =>
    set((state) => ({
      cartItems: state.cartItems.filter((item) => item.id !== id),
    })),

  updateQuantity: (id, quantity) =>
    set((state) => ({
      cartItems: state.cartItems.map((item) =>
        item.id === id ? { ...item, quantity } : item,
      ),
    })),

  clearCart: () => set({ cartItems: [] }),
}));
