import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WeekDealComponent } from './week-deal.component';

describe('WeekDealComponent', () => {
  let component: WeekDealComponent;
  let fixture: ComponentFixture<WeekDealComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WeekDealComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WeekDealComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
