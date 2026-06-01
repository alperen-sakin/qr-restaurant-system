import { ArrowRight } from "lucide-react";

type PriceBoxProps = {
  subtotal: number;
  taxRate?: number;
};

const PriceBox = ({ subtotal, taxRate = 0.1 }: PriceBoxProps) => {
  const tax = subtotal * taxRate;
  const total = subtotal + tax;

  return (
    <div className="flex flex-col gap-3 mt-6 p-5 border border-borderColor rounded-3xl bg-white shadow-sm">
      <div className="flex justify-between text-sm text-gray-500">
        <span>Subtotal</span>
        <span>${subtotal.toFixed(2)}</span>
      </div>
      <div className="flex justify-between text-sm text-gray-500">
        <span>Tax (10%)</span>
        <span>${tax.toFixed(2)}</span>
      </div>
      <div className="flex justify-between border-t border-borderColor pt-3 mt-3 text-base font-semibold text-primary">
        <span>Total</span>
        <span>${total.toFixed(2)}</span>
      </div>

      <button className="mt-4 w-full inline-flex items-center justify-center gap-2 rounded-2xl bg-primary px-4 py-3 text-sm font-semibold text-white transition hover:bg-primary-dark">
        Confirm Order
        <ArrowRight className="w-5 h-5" />
      </button>
    </div>
  );
};

export default PriceBox;
