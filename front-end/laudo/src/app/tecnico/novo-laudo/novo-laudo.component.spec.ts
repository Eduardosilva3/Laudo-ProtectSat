import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NovoLaudoComponent } from './novo-laudo.component';

describe('NovoLaudoComponent', () => {
  let component: NovoLaudoComponent;
  let fixture: ComponentFixture<NovoLaudoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NovoLaudoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NovoLaudoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
