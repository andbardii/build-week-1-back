import { TestBed } from '@angular/core/testing';

import { MacchinistaService } from './macchinista.service';

describe('MacchinistaService', () => {
  let service: MacchinistaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MacchinistaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
