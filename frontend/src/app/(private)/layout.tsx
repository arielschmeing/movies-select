"use client"

import Menu from "./_components/menu";
import { useProfile } from "./_hooks/useProfile";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  useProfile()

  return (
    <main className="w-full h-full flex">
      <Menu />
      <div className="min-h-screen w-full relative">
        {children}
      </div>
    </main>
  );
}
