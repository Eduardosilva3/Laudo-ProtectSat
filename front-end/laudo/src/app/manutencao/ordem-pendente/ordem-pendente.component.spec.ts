import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdemPendenteComponent } from './ordem-pendente.component';

describe('OrdemPendenteComponent', () => {
  let component: OrdemPendenteComponent;
  let fixture: ComponentFixture<OrdemPendenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdemPendenteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrdemPendenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
