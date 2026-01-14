export interface User {
  id: string;
  name: string;
  email: string;
  createdAt: Date;
  updatedAt: Date;
  activated: boolean;
  parties?: Party[];
}

export interface Party {
  id: string;
  name: string;
  createdAt: Date;
  updatedAt: Date;
  users: User[];
  owner?: User;
}

export interface Order {
  id: string;
  user: User;
  partyName: string;
  partyId: string;
  createdAt: Date;
}
