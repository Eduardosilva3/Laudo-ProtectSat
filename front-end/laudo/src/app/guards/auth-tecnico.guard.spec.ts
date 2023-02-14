import { TestBed } from '@angular/core/testing';

import { AuthTecnicoGuard } from './auth-tecnico.guard';

describe('AuthTecnicoGuard', () => {
  let guard: AuthTecnicoGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthTecnicoGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
