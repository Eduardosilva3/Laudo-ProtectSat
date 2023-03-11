import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetlhesDialogComponent } from './detlhes-dialog.component';

describe('DetlhesDialogComponent', () => {
  let component: DetlhesDialogComponent;
  let fixture: ComponentFixture<DetlhesDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetlhesDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetlhesDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
