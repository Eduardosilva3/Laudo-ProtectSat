import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListLaudoComponent } from './list-laudo.component';

describe('ListLaudoComponent', () => {
  let component: ListLaudoComponent;
  let fixture: ComponentFixture<ListLaudoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListLaudoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListLaudoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
