enum ApiRoot {
  Users = "/users",
  Parties = "/parties",
}

export const API_PATHS = {
  AUTH: "/auth/login",
  USERS: {
    ROOT: ApiRoot.Users,
    ID: (id: string) => `${ApiRoot.Users}/${id}`,
  },
  PARTIES: {
    ROOT: ApiRoot.Parties,
    ID: (id: string) => `${ApiRoot.Parties}/${id}`,
    ORDERS: (id: string) => `${ApiRoot.Parties}/${id}/orders`
  },
} as const;
