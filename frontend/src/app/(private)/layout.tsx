import Menu from "./_components/menu";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <main className="w-full h-full flex">
      <Menu />
      {children}  
    </main>
  );
}
