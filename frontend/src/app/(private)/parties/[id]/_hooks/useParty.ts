import { ROUTER_PATHS } from "@/src/constants/app.constants";
import { useQueryGetParty } from "@/src/hooks/queries/useQueryGetParty";
import { useParams, useRouter } from "next/navigation";

export const useParty = () => {
  const router = useRouter();
  const { id } = useParams<{ id: string }>();
  const { party } = useQueryGetParty({ id });
  const btnProps = {
    onClick: () => router.push(ROUTER_PATHS.PARTIES.ID.ORDERS(id)),
    className: "btn-primary",
  };

  return {
    party,
    btnProps,
  };
};
