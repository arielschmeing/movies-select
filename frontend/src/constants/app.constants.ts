export const ROUTER_PATHS = {
  ROOT: "/",
  LOGIN: "/login",
  REGISTER: "/register",
  PARTIES: {
    ROOT: "/parties",
    ID: {
      ROOT: (id: string) => `/parties/${id}`,
      ORDERS: (id: string) => `/parties/${id}/orders`,
    },
  },
  USER: "/user",
  SEARCH: "/search",
} as const;

export const COOKIES = {
  TOKEN: "ACCESS_TOKEN",
} as const;

export const QUERY_KEYS = {
  USER_PROFILE: ["user"],
  GET_PARTY: (id: string) => ["party", id],
  GET_ORDERS: (id: string) => ["orders", id],
} as const;
