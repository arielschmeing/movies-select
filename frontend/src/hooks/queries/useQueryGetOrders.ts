import { QUERY_KEYS } from "@/src/constants/app.constants";
import { partyService } from "@/src/services";
import { useQuery } from "@tanstack/react-query";

const UPDATE_TIME = 25000;

export const useQueryGetOrders = ({ id }: { id: string }) => {
  const { data } = useQuery({
    queryKey: QUERY_KEYS.GET_ORDERS(id),
    queryFn: async () => await partyService.getOrders({ id }),
    refetchOnWindowFocus: true,
    gcTime: UPDATE_TIME,
    staleTime: UPDATE_TIME,
  });

  return {
    orders: data,
  };
};
