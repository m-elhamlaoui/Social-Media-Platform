import { Post } from "../Post/post";
export class Posts {
  items !: Post[];
  total !: number;
  page !: number;
  perPage !: number;
  totalPages !: number;
}
