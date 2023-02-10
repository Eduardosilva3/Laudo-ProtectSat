import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgressoLaudoComponent } from './progresso-laudo.component';

describe('ProgressoLaudoComponent', () => {
  let component: ProgressoLaudoComponent;
  let fixture: ComponentFixture<ProgressoLaudoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgressoLaudoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProgressoLaudoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
