import { TestBed } from '@angular/core/testing';

import { ErrorResponseService } from './error-response.service';

describe('ErrorResponseService', () => {
  let service: ErrorResponseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ErrorResponseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
