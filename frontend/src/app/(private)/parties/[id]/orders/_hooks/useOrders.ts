import { useQueryGetOrders } from "@/src/hooks/queries/useQueryGetOrders";
import { useParams } from "next/navigation";

export const useOrders = () => {
  const { id } = useParams<{ id: string }>();
  const { orders } = useQueryGetOrders({ id });

  return {
    orders
  };
};
