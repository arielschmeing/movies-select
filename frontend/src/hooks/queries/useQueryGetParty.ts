import { QUERY_KEYS } from "@/src/constants/app.constants";
import { partyService } from "@/src/services";
import { useQuery } from "@tanstack/react-query";

export const useQueryGetParty = ({ id }: { id: string }) => {
  const { data } = useQuery({
    queryKey: QUERY_KEYS.GET_PARTY(id),
    queryFn: async () => await partyService.get({ id }),
    refetchOnWindowFocus: true,
  });

  return {
    party: data,
  };
};
