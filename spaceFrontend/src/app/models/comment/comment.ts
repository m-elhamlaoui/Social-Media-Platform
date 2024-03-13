import { User } from "../user/user";

export class Comment {
    description!: string;
    user!: User;
    date!: Date;
    likes!: number;
}
