import { User } from "../user/user";

export class Post {
    user!: User;
    text!: string;
    image!: string;
    reaction!: string[];
    comments!: Comment[];
    date!: Date;
}
