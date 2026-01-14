"use client";

import { useOrders } from "./_hooks/useOrders";

export default function Page() {
  const { orders } = useOrders();

  return (
    <section>
      {orders?.map((order) => (
        <p key={order.id}>{order.id}</p>
      ))}
      {orders?.length === 0 && (
        <h1 className="text-neutral-200 text-2xl font-semibold">
          Sem pedidos pendentes.
        </h1>
      )}
    </section>
  );
}
