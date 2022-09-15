import { TestBed } from '@angular/core/testing';

import { TableCustomerService } from './table-customer.service';

describe('TableCustomerService', () => {
  let service: TableCustomerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TableCustomerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
