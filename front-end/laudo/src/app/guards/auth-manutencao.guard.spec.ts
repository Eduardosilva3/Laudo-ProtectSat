import { TestBed } from '@angular/core/testing';

import { AuthManutencaoGuard } from './auth-manutencao.guard';

describe('AuthManutencaoGuard', () => {
  let guard: AuthManutencaoGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthManutencaoGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
