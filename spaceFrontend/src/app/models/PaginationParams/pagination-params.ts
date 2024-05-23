export interface PaginationParams {
    [param: string]:
      | string
      | number
      | boolean
      | ReadonlyArray<string | number | boolean>;
    page: number;
    perPage: number;
  }