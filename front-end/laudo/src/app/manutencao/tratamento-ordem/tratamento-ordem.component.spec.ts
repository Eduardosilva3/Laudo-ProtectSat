import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TratamentoOrdemComponent } from './tratamento-ordem.component';

describe('TratamentoOrdemComponent', () => {
  let component: TratamentoOrdemComponent;
  let fixture: ComponentFixture<TratamentoOrdemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TratamentoOrdemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TratamentoOrdemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
