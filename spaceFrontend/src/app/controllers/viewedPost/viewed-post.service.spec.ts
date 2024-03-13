import { TestBed } from '@angular/core/testing';

import { ViewedPostService } from './viewed-post.service';

describe('ViewedPostService', () => {
  let service: ViewedPostService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewedPostService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
