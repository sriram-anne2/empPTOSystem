import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TakeVacationComponent } from './take-vacation.component';

describe('TakeVacationComponent', () => {
  let component: TakeVacationComponent;
  let fixture: ComponentFixture<TakeVacationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TakeVacationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TakeVacationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
