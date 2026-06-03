"use client";

import { QRCodeCanvas } from "qrcode.react";

const QRCodePage = () => {
  const tables = Array.from({ length: 10 }, (_, i) => i + 1);

  const baseUrl = "http://localhost:3000/menu";

  return (
    <div className="p-8 max-w-4xl mx-auto">
      <h1 className="text-2xl font-bold mb-6">Table QR Codes</h1>

      <div className="grid grid-cols-1  gap-8">
        {tables.map((tableNumber) => (
          <div
            key={tableNumber}
            className="flex flex-col items-center gap-4 p-4 border rounded-xl shadow-sm"
          >
            <h2 className="text-lg font-bold text-primary">
              Table {tableNumber}
            </h2>

            <QRCodeCanvas
              value={`${baseUrl}?table=${tableNumber}`}
              size={150}
            />

            <p className="text-xs text-gray-400 text-center">
              Save the QR code and place it on the table. When customers scan
              it, they will be directed to the menu page with their table number
              pre-selected.
            </p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default QRCodePage;
